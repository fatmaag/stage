
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class Formulaire extends JFrame implements MouseListener {

    Connection conn = null;
    Statement state = null;
    static JTextField name_txt;

    static JTextArea add_txtArea;
    static JTextField email_txt;
    static JButton submit_btn;
    static JLabel name_lbl;
    static JLabel add_lbl;
    static JLabel email_lbl;

    public Formulaire() {

        this.setVisible(true);

        this.setBounds(200, 100, 700, 600);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Container c = this.getContentPane();
        c.setLayout(null);

        JLabel heading_lbl = new JLabel();
        heading_lbl.setBounds(250, 5, 200, 40);

        name_lbl = new JLabel("Nom : ");
        name_lbl.setBounds(50, 80, 100, 30);

        name_txt = new JTextField();
        name_txt.setBounds(180, 80, 180, 30);

        add_lbl = new JLabel(" ProblÃ©me ou Avis :");
        add_lbl.setBounds(50, 100, 200, 201);

        // Creating JTextArea for the address
        add_txtArea = new JTextArea();
        add_txtArea.setBounds(180, 240, 180, 100);

        email_lbl = new JLabel("Email : ");
        email_lbl.setBounds(50, 390, 100, 30);

        // Creating JTextField for the Email
        email_txt = new JTextField();
        email_txt.setBounds(180, 390, 180, 30);

        submit_btn = new JButton("Envoyer");
        submit_btn.setBounds(180, 470, 120, 40);

        /* submit_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            }
        }); */
        c.add(name_lbl);
        c.add(add_lbl);
        c.add(email_lbl);
        c.add(name_txt);

        c.add(add_txtArea);
        c.add(email_txt);
        c.add(submit_btn);
        submit_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    try {			
                        Class.forName("com.mysql.jdbc.Driver");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Formulaire.class.getName()).log(Level.SEVERE, null, ex);
                    }
			conn= DriverManager.getConnection("jdbc:mysql://localhost/projet","root","");
		}
		catch (SQLException  e) {
			// TODO Auto-generated catch block
			System.err.println("erre");}
	                  
        		String rq= "INSERT INTO projet(nom,texte,email)VALUES(?,?,?)";
            	  try( PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(rq) ) { //préparation de la requête 
            		  
      			    preparedStatement.setObject(1, name_txt.getText());  
      			    preparedStatement.setObject(2, add_txtArea.getText());
      			    preparedStatement.setObject(3, email_txt .getText());
      			    if(preparedStatement.executeUpdate()!=0){
      			    	JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs ","Information Message",JOptionPane.ERROR_MESSAGE);}
      			    else{JOptionPane.showMessageDialog(null, "Message envoyé !", 
                              "Information Message",
                              JOptionPane.INFORMATION_MESSAGE);
      	    		dispose();}
                }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            }

        });
        

  /*   submit_btn.addMouseListener(new MouseAdapter () {
    	public void mouseClicked(MouseEvent arg0) {
    		JOptionPane.showMessageDialog(null, "Envoyé !");

    	}	*/

    }

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
    
}
