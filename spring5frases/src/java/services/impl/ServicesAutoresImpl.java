package services.impl;

import java.util.List;
import java.util.Optional;
import model.Autores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import repository.RepositoryAutores;
import services.ServicesAutores;

@Service
public class ServicesAutoresImpl implements ServicesAutores {

    @Autowired
    private RepositoryAutores repositoryAutores;

    @Override
    public List<Autores> autoresCbo() {
        List<Autores> list = repositoryAutores.findAll();
        return list;
    }

    @Override
    public List<Autores> autoresQry() {
        List<Autores> list = repositoryAutores.findAll();
        return list;
    }

    @Override
    public String autoresInsUpd(Autores autores) {
        String result = null;

        try {
            repositoryAutores.save(autores);

        } catch (DataIntegrityViolationException e) {
            result = "Autor ya fué registrado";
        }

        return result;
    }

    @Override
    public String autoresDel(List<Integer> ids) {
        String result = null;

        List<Autores> list = repositoryAutores.findAllById(ids);

        if (ids.size() == list.size()) { // lista de IDs debe ser igual a objetos obtenidos
            repositoryAutores.deleteInBatch(list);

        } else {
            result = "IDs incorrectos";
        }

        return result;
    }

    @Override
    public Autores autoresGet(Integer idautor) {
        Optional opt = repositoryAutores.findById(idautor);

        Autores autores = null;
        if (opt.isPresent()) {
            autores = (Autores) opt.get();
        }

        return autores;
    }

}
