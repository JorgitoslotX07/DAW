package m03.repositories;

import java.util.List;

import m03.objects.Treballador;

public interface TreballadorRepository {
    public void guardarFitxer();

    public List<Treballador> getLlistaTreballadors();

    public void createTreballador(Treballador t);

    public Treballador getAllTrebaladorsByDNI(String dni);

    public Treballador getAllTrebaladorsById(String id);

}
