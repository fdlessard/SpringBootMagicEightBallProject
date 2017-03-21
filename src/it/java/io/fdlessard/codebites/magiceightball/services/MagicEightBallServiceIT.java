package io.fdlessard.codebites.magiceightball.services;

import io.fdlessard.codebites.magiceightball.SpringBootMagicEightBallApplication;
import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.repositories.MagicEightBallRepository;
import io.fdlessard.codebites.magiceightball.tenant.MultiTenantJpaTransactionManager;
import io.fdlessard.codebites.magiceightball.tenant.TenantResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by fdlessard on 17-03-08.
 */
@RunWith(SpringRunner.class)
//@TestPropertySource("application.yml")
@SpringBootTest(classes = {SpringBootMagicEightBallApplication.class, MultiTenantJpaTransactionManager.class})
//@DataJpaTest
@ActiveProfiles("integration")
public class MagicEightBallServiceIT {

/*    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private MagicEightBallRepository repository;*/

    @Autowired
    private MultiTenantJpaTransactionManager transactionManager;

    @Autowired
    private TenantResolver tenantResolver;

    @Autowired
    private MagicEightBallService magicEightBallService;

    @Before
    public void setUp() throws Exception {
        tenantResolver.setCurrentTenant("default");
    }

    private MagicEightBallAnswer buildMagicEightBallAnswer() {
        MagicEightBallAnswer magicEightBallAnswer = new MagicEightBallAnswer();
        magicEightBallAnswer.setTenantId("ATenant");
        magicEightBallAnswer.setMessage("message 4");
        magicEightBallAnswer.setColor("red");

        return magicEightBallAnswer;
    }

 //   @Test
    public void shake() throws Exception {

    }

  //  @Test
    public void getById() throws Exception {
//        MagicEightBallAnswer magicEightBallAnswer = magicEightBallService.getById(0);
//        assertNotNull(magicEightBallAnswer);
    }

    //@Test
  public void getByIds() throws Exception {
 //       MagicEightBallAnswer magicEightBallAnswer = magicEightBallService.getById(0);
 //       assertNotNull(magicEightBallAnswer);
    }

   // @Test
    public void getAll() throws Exception {

    }

    //@Test
    public void deleteById() throws Exception {

    }

//    @Test
    public void save() throws Exception {
        magicEightBallService.save(buildMagicEightBallAnswer());
        MagicEightBallAnswer magicEightBallAnswer = magicEightBallService.getById(0);
        assertNotNull(magicEightBallAnswer);


    }

}