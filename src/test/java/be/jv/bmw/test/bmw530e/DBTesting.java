package be.jv.bmw.test.bmw530e;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import be.jv.bmw.data.dynamic.Dynamic;
import be.jv.bmw.data.repositories.DynamicRespository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DBTesting {

	@Autowired private DynamicRespository dynamicRespository;
	@Test
	public void DynamicFetch () {
		assertThat(dynamicRespository).isNotNull();
    	String dynamicDate = "03.02.2021";
    	List<Dynamic> dyns = dynamicRespository.findByDate(dynamicDate);
    	assertTrue(dyns.size()>0);

	}
}
