package m03.controllers;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import m03.objects.Encarregat;
import m03.objects.Treballador;
import m03.repositories.TreballadorRepository;
import m03.repositories.repositoriesImpl.XMLFileTreballadorRepository;
import m03.services.TreballadorService;

@Controller
public class TreballadorController {
    private static final Logger logger = LogManager.getLogger(TreballadorController.class);
    private TreballadorService treballadorService;

    public TreballadorController(TreballadorService treballadorService) {
        this.treballadorService = treballadorService;
    }

    public void addTreballador(String nom, String cognoms, String dni, String dia, String mes, String any,
            String salari, String salariExtra, Boolean indEncarregat) {
        LocalDate dataNaixement = LocalDate.of(Integer.parseInt(any), Integer.parseInt(mes),
                Integer.parseInt(dia));
        Double salariBase = Double.parseDouble(salari);
        Double souExtra = Double.parseDouble(salariExtra);

        if (!indEncarregat) {
            Treballador treballador = new Treballador(nom, cognoms, dni, dataNaixement, salariBase);
            treballadorService.addTreballador(treballador);
            logger.info("New Treballador added: {}", treballador);
        } else {
            Encarregat encarregat = new Encarregat(nom, cognoms, dni, dataNaixement, salariBase, souExtra);
            encarregat.setSouExtra(500);
            treballadorService.addTreballador(encarregat);
            logger.info("New Encarregat added: {}", encarregat);
        }
    }

    public List<Treballador> getLlistaTreballadors() {
        return treballadorService.getLlistaTreballadors();
    }

    public static void main(String[] args) {
        TreballadorRepository repository = new XMLFileTreballadorRepository();
        TreballadorService service = new TreballadorService(repository);

        Encarregat nuevoTreballador = new Encarregat();
        nuevoTreballador.setNom("Nue");
        nuevoTreballador.setCognoms("Trabajador");
        nuevoTreballador.setDni("12345578A");
        nuevoTreballador.setDataNaixement(LocalDate.of(1990, 1, 1));
        nuevoTreballador.setSalariBase(2500.0);
        nuevoTreballador.setSouExtra(500);

        service.addTreballador(nuevoTreballador);
    }
}
