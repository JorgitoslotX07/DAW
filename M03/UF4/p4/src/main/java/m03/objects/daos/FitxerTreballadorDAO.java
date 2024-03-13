package m03.objects.daos;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "treballadors")
@XmlAccessorType(XmlAccessType.FIELD)

public class FitxerTreballadorDAO {
    @XmlElement(name = "treballador")
    private List<TreballadorDAO> treballadors;

    public List<TreballadorDAO> getTreballadors() {
        return treballadors;
    }

    public void setTreballadors(List<TreballadorDAO> treballadors) {
        this.treballadors = treballadors;
    }

}
