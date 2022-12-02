package polije.ppl.tailor.service;

import java.util.HashMap;
import java.util.List;

import polije.ppl.tailor.data.SessionData;
import polije.ppl.tailor.entity.Account;
import polije.ppl.tailor.repository.AccountRepository;
import polije.ppl.tailor.repository.Repository;

public class AuthService {
    private Repository<Account> accRepo = new AccountRepository();

    public boolean login(String username, String password) {
        List<Account> accs = accRepo.get(new HashMap<String, Object>() {{
            put("username", username);
            put("password", password);
        }});

        if(accs.size() < 1) return false;

        SessionData.account = accs.get(0);
        return true;
    }

    public boolean forgotPassword(String username, String email) {
        List<Account> accs = accRepo.get(new HashMap<String, Object>() {{
            put("username", username);
            put("email", email);
        }});

        if(accs.size() < 1) return false;

        return true;
    }
}
