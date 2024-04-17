package demo.service;

import demo.model.Produto;
import demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto entity) {

        //regras de negócio para salvar

        return  repository.save(entity);
    }

    public List<Produto> buscaTodos() { return  repository.findAll();}

    public Produto buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Produto alterar(Long id, Produto alterado) {
        Optional<Produto> encontrado = repository.findById(id);
        if(encontrado.isPresent()) {
            Produto produto = encontrado.get();
            produto.setNome(alterado.getNome());
            produto.setValor(alterado.getValor());
            produto.setEstoque(alterado.getEstoque());

            // testar se verifica as mesmas coisas que o salvar

            return repository.save(produto);
        }
        return null;}

    public void remover(Long id) { repository.deleteById(id);}


}
