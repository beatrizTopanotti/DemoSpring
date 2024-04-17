package demo.service;

import demo.enterprise.ValidationException;
import demo.model.Cliente;
import demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente entity) {

        //regras de negócio para salvar

        // nesse caso eu poderia criar uma função para as verificações
        // que são tanto do criar quanto do editar
        if(entity.getCpf().length() < 9){
            throw new ValidationException("o cpf tem número mínimo");
        }

        return  repository.save(entity);
    }

    public List<Cliente> buscaTodos() { return  repository.findAll();}

    public Cliente buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cliente alterar(Long id, Cliente alterado) {
        Optional<Cliente> encontrado = repository.findById(id);
        if(encontrado.isPresent()) {
            Cliente cliente = encontrado.get();
            cliente.setNome(alterado.getNome());
            cliente.setCpf(alterado.getCpf());
            cliente.setEndereco(alterado.getEndereco());

            // testar se verifica as mesmas coisas que o salvar

            return repository.save(cliente);
        }
        return null;}

    public void remover(Long id) { repository.deleteById(id);}

}
