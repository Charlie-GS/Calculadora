import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class MutableColoredButton extends JFrame {

    final private JButton btn = new JButton("Click Me");
    final private ButtonsListener bl = new ButtonsListener();

    private static boolean defaultColor = true;


    /**
     * Main method: 
     * @param args 
     */
    public static void main( String[] args ) {
        new MutableColoredButton().setVisible( true );
    }

    /**
     * Contruct
     * 
     */
    public MutableColoredButton() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(300, 230);
        setTitle("Button test");

        this.setButton();
    }

    private void setButton() {
        // Set buttons size
        // setPreferredSize(java.awt.Dimension)
        // Dimension(float width, float height)
        btn.setPreferredSize(new Dimension(140, 60));

        // Add a default backgroung color to the button
        btn.setBackground(Color.YELLOW);

        // Add listener to the button
        btn.addActionListener(bl);

        // Add the button to the frame
        add(btn);
    }


    class ButtonsListener implements ActionListener {

        @Override
        public void actionPerformed( ActionEvent e ) {
            System.out.println("Button clicked !"); // HACK: trace

            if (defaultColor) {
                defaultColor = false;
                btn.setBackground(Color.BLUE);
            } else {
                defaultColor = true;
                btn.setBackground(Color.YELLOW);
            }    
        }

    } //class ButtonsListener

} // class