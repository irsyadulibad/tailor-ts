package polije.ppl.tailor.util;

import javax.swing.JFrame;

import polije.ppl.tailor.data.AccountRole;
import polije.ppl.tailor.data.SessionData;
import polije.ppl.tailor.view.admin.DashboardAdminView;
import polije.ppl.tailor.view.tailor.DashBoardPenjahitView;

public class ViewUtil {
    public <T extends JFrame> void authRedirector(T view) {
        AccountRole role = SessionData.account.getRole();

        if(role == AccountRole.admin) new DashboardAdminView().setVisible(true);
        if(role == AccountRole.tailor) new DashBoardPenjahitView().setVisible(true);
        view.dispose();
    }
}
