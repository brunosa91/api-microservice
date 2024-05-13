package com.ibmshop.userapi.domain.repositories;





















































































































































































































































































































































import com.ibmshop.userapi.domain.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static com.ibmshop.userapi.common.UserConstant.USER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void createUser_WithValidaData_ReturnPlanet() {

        UserEntity userEntity = userRepository.save(USER);
        UserEntity sut = testEntityManager.find(UserEntity.class, userEntity.getId());

        assertThat(sut).isNotNull();
        assertThat(sut.getNome()).isEqualTo(USER.getNome());
        assertThat(sut.getSobrenome()).isEqualTo(USER.getSobrenome());
        assertThat(sut.getCpf()).isEqualTo(USER.getCpf());
        assertThat(sut.getEmail()).isEqualTo(USER.getEmail());

        assertThat(sut.getAtivo()).isEqualTo(USER.getAtivo());

    }

    @Test
    public void createUser_WithInvalidaData_ThrowsException() {


        UserEntity emptyUserEntity = new UserEntity();


        assertThatThrownBy(() -> userRepository.save(emptyUserEntity)).isInstanceOf(RuntimeException.class);

    }

    @Test
    public void testFindByNome() {
        UserEntity user = new UserEntity();
        user.setNome("João");
        user.setCpf("34544887372");
        user.setTelefone("(11)98586-2452");
        user.setSobrenome("da Silva");
        user.setAtivo(true);
        testEntityManager.persist(user);
        testEntityManager.flush();

        List<UserEntity> result = userRepository.findByNome("João");

        //assertThat(result.get(0)).isTrue();
        assertThat(result.get(0).getNome()).isEqualTo("João");
    }

    @Test
    public void testFindByCpf() {
        UserEntity user = new UserEntity();
        user.setNome("Maria Souza");
        user.setCpf("39650590846");
        user.setTelefone("(11)98586-2452");
        user.setSobrenome("da Silva");
        user.setAtivo(true);
        testEntityManager.persist(user);
        testEntityManager.flush();

        Optional<UserEntity> result = userRepository.findByCpf("39650590846");

        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getNome()).isEqualTo("Maria Souza");
    }

    @Test
    public void testFindByAtivoTrue() {
        UserEntity user1 = new UserEntity();
        user1.setNome("João da Silva");
        user1.setCpf("00998515124");
        user1.setTelefone("(11)98586-2452");
        user1.setSobrenome("da Silva");
        user1.setAtivo(true);
        testEntityManager.persist(user1);

        UserEntity user2 = new UserEntity();
        user2.setNome("Maria Souza");
        user2.setCpf("88640345872");
        user2.setTelefone("(11)98586-2452");
        user2.setSobrenome("da Silva");
        user2.setAtivo(false);
        testEntityManager.persist(user2);

        testEntityManager.flush();

        List<UserEntity> result = userRepository.findByAtivoTrue();

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getNome()).isEqualTo("João da Silva");
    }
}