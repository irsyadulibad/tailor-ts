package polije.ppl.tailor.service;

import java.util.HashMap;
import java.util.List;

import polije.ppl.tailor.data.SessionData;
import polije.ppl.tailor.entity.Account;
import polije.ppl.tailor.entity.Verification;
import polije.ppl.tailor.repository.AccountRepository;
import polije.ppl.tailor.repository.Repository;
import polije.ppl.tailor.repository.VerificationRepository;
import polije.ppl.tailor.util.AuthUtil;

public class AuthService {
    private VerificationRepository verifyRepo = new VerificationRepository();
    private Repository<Account> accRepo = new AccountRepository();
    private EmailService mailService = new EmailService();

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

        String code = AuthUtil.generateCode();
        if(verifyRepo.add(new Verification(accs.get(0), code)) == 0) return false;
        if(!mailService.sendVerificationEMail(email, code)) return false;

        return true;
    }
}
