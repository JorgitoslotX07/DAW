package m03.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import m03.objects.Encarregat;
import m03.objects.Treballador;
import m03.repositories.TreballadorRepository;

import org.springframework.stereotype.Service;
import ch.qos.logback.classic.Logger;
import co.elastic.clients.elasticsearch.indices.update_aliases.AddAction;

@Service
public class EncarregatService extends TreballadorService {
    private Logger Logger;
    private TreballadorRepository TreballadorRepository;

    public EncarregatService(TreballadorRepository treballadorRepository) {
        super(treballadorRepository);
    }

    public void addEncarregat(Encarregat e) {
        Treballador existingTreballador = getAllTrebaladorsByDNI(e.getDni());
        if (existingTreballador == null) {
            TreballadorRepository.createTreballador(e);
            // System.out.println("Nuevo trabajador agregado con éxito.");
        } else {
            // System.out.println("Ya existe un trabajador con el mismo DNI.");
        }
    }
}
