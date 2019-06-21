package com.khan.eureka;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class EurekaApplicationTests {

    @Test
    public void contextLoads() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		System.out.println(passwordEncoder.encode("123456"));
    }

}
