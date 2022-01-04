package com.ls.webapp.jsf3.services;

import com.ls.webapp.jsf3.entities.Categoria;
import com.ls.webapp.jsf3.entities.Producto;
import com.ls.webapp.jsf3.repositories.CrudRepository;
import com.ls.webapp.jsf3.repositories.ProductoRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProductoServiceImpl implements ProductoService {

    @Inject
    private ProductoRepository repository;

    @Inject
    CrudRepository<Categoria> categoriaRepository;

    @Override
    public List<Producto> listar() {
        return repository.listar();
    }

    @Override
    public Optional<Producto> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Producto producto) {
        repository.guardar(producto);
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }

    @Override
    public List<Categoria> ListarCategorias() {
        return categoriaRepository.listar();
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.ofNullable(categoriaRepository.porId(id));
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return repository.buscarPorNombre(nombre);
    }
}
