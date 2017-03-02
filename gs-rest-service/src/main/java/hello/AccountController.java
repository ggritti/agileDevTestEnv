package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/account")
	public Account account(@RequestParam(value = "name", defaultValue = "World") String name,
			@RequestParam(value = "lastname", defaultValue = "WorldLastname") String lastname) {
		return new Account(counter.incrementAndGet(), String.format(name), String.format(lastname));
	}
}
