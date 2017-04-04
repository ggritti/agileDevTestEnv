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

        // Switch-case construct example with literals with Java 7 and up
        String returnedNameString = getNameString(name);
        return new Account(counter.incrementAndGet(), returnedNameString, lastname);
    }

    /**
     * Example method to manage switch-case block based on literals
     *
     * @param name "Is the name to be processed"
     * @return "Is the processed after switch-case block"
     */
    private static String getNameString(String name) {

        String nameStr = "default";
        if (name == null) {
            return nameStr;
        }
        switch (name.toLowerCase()) {
            case "giordano":
                nameStr = "returnGiordano1";
                break;
            case "giordano2":
                nameStr = "returnedGiordano2";
                break;
            case "giordano3":
                nameStr = "returnedGiordano3";
                break;
            default:
                nameStr = "returnedGiordanoDef";
                break;
        }
        return nameStr;
    }
}
