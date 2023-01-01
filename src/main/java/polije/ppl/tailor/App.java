package polije.ppl.tailor;

import javax.swing.UIManager.LookAndFeelInfo;

import polije.ppl.tailor.view.LoadingView;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        try {
            for(LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels()) {
                if(info.getName().equals("Nimbus")) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch(Exception e) { e.printStackTrace(); }

        LoadingView.main(args);
    }
}
