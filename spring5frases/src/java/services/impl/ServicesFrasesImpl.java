package services.impl;

import java.util.List;
import java.util.Optional;
import model.Frases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import repository.RepositoryFrases;
import services.ServicesFrases;

@Service
public class ServicesFrasesImpl implements ServicesFrases {

    @Autowired
    private RepositoryFrases repositoryFrases;

    @Override
    public List<Frases> frasesQry() {
        List<Frases> list = repositoryFrases.findAll();
        return list;
    }

    @Override
    public String frasesInsUpd(Frases frases) {
        String result = null;

        try {
            repositoryFrases.save(frases);

        } catch (DataIntegrityViolationException e) {
            result = "Frase ya fué registrada";
        }

        return result;
    }

    @Override
    public String frasesDel(List<Integer> ids) {
        String result = null;

        List<Frases> list = repositoryFrases.findAllById(ids);

        if (ids.size() == list.size()) { // lista de IDs debe ser igual a objetos obtenidos
            repositoryFrases.deleteInBatch(list);

        } else {
            result = "IDs incorrectos";
        }

        return result;
    }

    @Override
    public Frases frasesGet(Integer idfrase) {
        Optional opt = repositoryFrases.findById(idfrase);

        Frases frases = null;
        if (opt.isPresent()) {
            frases = (Frases) opt.get();
        }

        return frases;
    }

}
