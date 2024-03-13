package m03.repositories.repositoriesImpl;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import m03.objects.Encarregat;
import m03.objects.Treballador;
import m03.objects.daos.FitxerTreballadorDAO;
import m03.objects.daos.TreballadorDAO;
import m03.repositories.TreballadorRepository;
import org.springframework.stereotype.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Repository
public class XMLFileTreballadorRepository implements TreballadorRepository {
    private static final Logger logger = LogManager.getLogger(XMLFileTreballadorRepository.class);
    private String RUTAFITXER = "M03/UF4/p4/src/main/resources/fitxerTreballadors.xml";
    List<Treballador> llistaTreballadors = getLlistaTreballadors();

    @Override
    public void guardarFitxer() {
        try {
            JAXBContext context = JAXBContext.newInstance(FitxerTreballadorDAO.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            List<Treballador> treballadors = llistaTreballadors;
            List<TreballadorDAO> treballadorsDAO = new ArrayList<>();
            for (Treballador treballador : treballadors) {
                TreballadorDAO treballadorDAO = new TreballadorDAO();

                treballadorDAO.setNom(treballador.getNom());
                treballadorDAO.setCognoms(treballador.getCognoms());
                treballadorDAO.setDni(treballador.getDni());
                treballadorDAO.setDataNaixement(
                        treballador.getDataNaixement().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                treballadorDAO.setSalariBase(treballador.getSalariBase());

                treballadorDAO.setIdTreballador(treballador.getId());

                if (treballador instanceof Encarregat) {
                    Encarregat encarregat = (Encarregat) treballador;
                    treballadorDAO.setIndEncarregat(true);
                    treballadorDAO.setLlistaTreballadors(new ArrayList<>());
                    treballadorDAO.setSouExtra(encarregat.getSouExtra());
                } else {
                    treballadorDAO.setIndEncarregat(false);
                }

                treballadorsDAO.add(treballadorDAO);
            }

            FitxerTreballadorDAO wrapper = new FitxerTreballadorDAO();
            wrapper.setTreballadors(treballadorsDAO);

            marshaller.marshal(wrapper, new File(RUTAFITXER));

            logger.info("Cambios guardados correctamente en el archivo XML.");
        } catch (JAXBException e) {
            logger.error("Error al guardar el archivo XML.", e);
        }
    }

    @Override
    public List<Treballador> getLlistaTreballadors() {
        try {
            JAXBContext context = JAXBContext.newInstance(FitxerTreballadorDAO.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            FitxerTreballadorDAO wrapper = (FitxerTreballadorDAO) unmarshaller.unmarshal(new File(RUTAFITXER));

            List<Treballador> treballadors = new ArrayList<>();
            for (TreballadorDAO dao : wrapper.getTreballadors()) {
                if (dao.getIndEncarregat()) {
                    Encarregat encarregat = new Encarregat();
                    encarregat.setNom(dao.getNom());
                    encarregat.setCognoms(dao.getCognoms());
                    encarregat.setDni(dao.getDni());
                    LocalDate fechaNacimiento = LocalDate.parse(dao.getDataNaixement(),
                            DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    encarregat.setDataNaixement(fechaNacimiento);
                    encarregat.setSalariBase(dao.getSalariBase());
                    encarregat.setSouExtra(dao.getSouExtra());
                    encarregat.setId(dao.getIdTreballador());
                    treballadors.add(encarregat);
                } else {
                    Treballador treballador = new Treballador();
                    treballador.setNom(dao.getNom());
                    treballador.setCognoms(dao.getCognoms());
                    treballador.setDni(dao.getDni());
                    LocalDate fechaNacimiento = LocalDate.parse(dao.getDataNaixement(),
                            DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    treballador.setDataNaixement(fechaNacimiento);
                    treballador.setSalariBase(dao.getSalariBase());
                    treballador.setId(dao.getIdTreballador());
                    treballadors.add(treballador);
                }
            }
            logger.info("Lista actual de trabajadores:");
            for (Treballador treballador : treballadors) {
                logger.info(treballador);
            }
            return treballadors;
        } catch (JAXBException e) {
            logger.error("Error al leer el archivo XML.", e);
            return new ArrayList<>();
        }
    }

    @Override
    public void createTreballador(Treballador t) {
        List<Treballador> treballadors = llistaTreballadors;
        treballadors.add(t);
        guardarFitxer();
    }

    @Override
    public Treballador getAllTrebaladorsByDNI(String dni) {
        List<Treballador> treballadors = getLlistaTreballadors();
        for (Treballador treballador : treballadors) {
            if (treballador.getDni() != null && treballador.getDni().equals(dni)) {
                logger.info("Trabajador encontrado por DNI:");
                logger.info(treballador);
                return treballador;
            }
        }
        logger.info("No se encontró ningún trabajador con el DNI especificado.");
        return null;
    }

    @Override
    public Treballador getAllTrebaladorsById(String id) {
        List<Treballador> treballadors = getLlistaTreballadors();
        for (Treballador treballador : treballadors) {
            if (treballador.getId() != null && treballador.getId().equals(id)) {
                logger.info("Trabajador encontrado por ID:");
                logger.info(treballador);
                return treballador;
            }
        }
        logger.info("No se encontró ningún trabajador con el DNI especificado.");
        return null;
    }

    public static void main(String[] args) {
        XMLFileTreballadorRepository repository = new XMLFileTreballadorRepository();
        List<Treballador> listaActual = repository.getLlistaTreballadors();
        logger.info("Lista actual de trabajadores:");
        for (Treballador treballador : listaActual) {
            logger.info(treballador);
        }

        Encarregat nuevoTreballador = new Encarregat();
        nuevoTreballador.setNom("Nuevo");
        nuevoTreballador.setCognoms("Trabajador");
        nuevoTreballador.setDni("12345578A");
        nuevoTreballador.setDataNaixement(LocalDate.of(1990, 1, 1));
        nuevoTreballador.setSalariBase(2500.0);
        nuevoTreballador.setSouExtra(500);

        Treballador treballadorByDNI = repository.getAllTrebaladorsByDNI("00000000T");
        if (treballadorByDNI != null) {
            logger.info("Trabajador encontrado por DNI:");
            logger.info(treballadorByDNI);
        } else {
            logger.info("No se encontró ningún trabajador con el DNI especificado.");
        }

        Treballador treballadorById = repository.getAllTrebaladorsById("6a9d50b4-e064-4fa8-b3b7-9afc3573f451");
        if (treballadorById != null) {
            logger.info("Trabajador encontrado por ID:");
            logger.info(treballadorById);
        } else {
            logger.info("No se encontró ningún trabajador con el ID especificado.");
        }

        logger.info(nuevoTreballador);
        repository.createTreballador(nuevoTreballador);
        logger.info("Nuevo trabajador creado.");
    }

}
