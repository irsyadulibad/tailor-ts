package polije.ppl.tailor.util;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

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

    public static <T extends JTable> void hideTableColumn(T table, int index) {
        table.getColumnModel().getColumn(index).setMinWidth(0);
        table.getColumnModel().getColumn(index).setMaxWidth(0);
        table.getColumnModel().getColumn(index).setResizable(false);
    }

    public static <E extends JTextField> void replaceNumberInput(E input) {
        String str = input.getText();
        input.setText(str.replaceAll("[^\\d]", ""));
    }
}
