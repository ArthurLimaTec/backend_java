package example.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.model.Produto;
import example.model.exception.ResourceNotFoundException;
import example.repository.ProdutoRepository;
import example.shared.ProdutoDTO;


@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> obterTodos(){
        List<Produto> a = produtoRepository.findAll();
        return a.stream().map(produto -> new ModelMapper().map(produto,ProdutoDTO.class))
        .collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    public Optional<ProdutoDTO> obterPorId(Integer id){
        Optional<Produto> a = produtoRepository.findById(id);
        if(a.isEmpty()){
            throw new ResourceNotFoundException("Produto com id: "+id+" não encontrado!");
        }
        ProdutoDTO dto = new ModelMapper().map(a.get(), ProdutoDTO.class);
        return Optional.of(dto);
    }

    @SuppressWarnings("null")
    public ProdutoDTO adicionar(ProdutoDTO produtoDto){
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDto, Produto.class);
        
        //Salvando o produto no BD para gerar o ID:
        produto = produtoRepository.save(produto);

        //Mapeando de volta para DTO com o ID gerado:
        produtoDto = mapper.map(produto, ProdutoDTO.class);

        return produtoDto;
    }

    @SuppressWarnings("null")
    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto){
        produtoDto.setId(id);

        //Objeto de mapeamento:
        ModelMapper mapper = new ModelMapper();

        //Converte o ProdutoDTO em Produto:
        Produto produto = mapper.map(produtoDto, Produto.class);

        //Atualiza o produto no BD:
        produtoRepository.save(produto);

        return produtoDto;
    }

    @SuppressWarnings("null")
    public void deletar(Integer id){
        //Verifica se o produto existe:
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível deletar o produto com id: "+id+". Pois o produto não existe!");
        }
        //Deleta pelo id:
        produtoRepository.deleteById(id);
    }
}