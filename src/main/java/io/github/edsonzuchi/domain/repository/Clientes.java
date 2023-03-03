package io.github.edsonzuchi.domain.repository;

import io.github.edsonzuchi.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNameLike(String nome);

    List<Cliente> findByNameOrIdOrderById(String nome, Integer id);

    Cliente findOneByName(String nome);

    boolean existsByName(String nome);

    @Query(value = "select c from Cliente c where c.name like :name")
    List<Cliente> encontrarPorNome( @Param("name") String nome);

    @Query(value = "select * from cliente c where c.nome like '%:name%'", nativeQuery = true)
    List<Cliente> encontrarPorNomeNativo( @Param("name") String nome);

    @Modifying
    void deleteByName(String nome);

    @Query("select c from Cliente c left join fetch c.pedidos where c.id = :id")
    Cliente findClienteFetchPedidos( @Param("id") Integer id);


}
