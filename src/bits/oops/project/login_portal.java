/*
 * Created by JFormDesigner on Tue Nov 13 15:21:24 IST 2018
 */

package bits.oops.project;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicBorders;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.factories.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import info.clearthought.layout.*;
import org.jdesktop.swingx.*;*/

/**
 * @author Shreeya
 */
public class login_portal extends JPanel {
    private final JFrame parent;

    public login_portal(JFrame parent) {
        this.parent=parent;
        initComponents();
        nameerror.setVisible(false);
        emailerror.setVisible(false);
        passworderror.setVisible(false);
        usernameerror.setVisible(false);
        contacterror.setVisible(false);
        label1.setVisible(false);
        label2.setVisible(false);
        registeredUser=null;
    }

    private void RegisterActionPerformed(ActionEvent e) {
        // TODO add your code here
        boolean flag=false;
        label1.setVisible(false);
        label2.setVisible(false);
        if(nametext.getText().equals("")) {
                flag=true;
                nameerror.setVisible(true);
            }
        else nameerror.setVisible(false);
       /* if(emailidtext.getText().equals("")) {
            flag=true;
            emailerror.setVisible(true);
            emailidtextActionPerformed(emailidtext);
        }
        else emailerror.setVisible(false);*/
       emailidtextActionPerformed(emailidtext);
       flag=true;

        if(usernametext.getText().equals("")) {
            flag=true;
            usernameerror.setVisible(true);
        }
        else usernameerror.setVisible(false);
      /*  if(passwordField1.getText().equals("")) {
            flag=true;
            passworderror.setVisible(true);
            passwordtextActionPerformed(passwordField1);
        }
        else passworderror.setVisible(false);*/
      passwordtextActionPerformed(passwordField1);
      flag=true;

      /*  if(contacttext.getText().equals("")) {
            flag=true;
            contacterror.setVisible(true);
            contacttextcheck(contacttext);
        }
        else contacterror.setVisible(false);*/contacttextcheck(contacttext);
        if(flag) {
            return;
        }
        else{
            Register.setText("Hang on");
            Register.setEnabled(false);
        }
        int status = MysqlCon.getInstance().register(usernametext.getText(),nametext.getText(),emailidtext.getText(),contacttext.getText(),addresstext.getText(),passwordField1.getPassword().toString());
        if(status==1){//registered
            label2.setVisible(true);
            registeredUser = new User(usernametext.getText(),nametext.getText(),emailidtext.getText(),contacttext.getText(),addresstext.getText(),passwordField1.getPassword().toString());
            parent.dispose();
        }
        else {
            label1.setVisible(true);
            Register.setText("Register");
            Register.setEnabled(true);
        }

    }

    private boolean contacttextcheck(JFormattedTextField contacttext)
    {

        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        if(contacttext==null){
            contacterror.setVisible(true);
            return false;
        }
        boolean matches2 = p.matcher(contacttext.getText()).matches();
        if(matches2==false)
        {
            contacterror.setVisible(true);
        }
        return matches2;
    }


    private boolean emailidtextActionPerformed(JFormattedTextField emailidtext) {

        // TODO add your code here
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern p = Pattern.compile(emailRegex);
        if (emailidtext == null) {
            emailerror.setVisible(true);
            return false;
        }

        boolean matches = p.matcher(emailidtext.getText()).matches();
        if(matches==false)
        {
            emailerror.setVisible(true);
        }
        return matches;
    }

    private boolean passwordtextActionPerformed(JPasswordField passwordField1) {
        // TODO add your code here
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        /*(?=.*[0-9]) a digit must occur at least once
(?=.*[a-z]) a lower case letter must occur at least once
(?=.*[A-Z]) an upper case letter must occur at least once
(?=.*[@#$%^&+=]) a special character must occur at least once
(?=\\S+$) no whitespace allowed in the entire string
.{8,} at least 8 character*/
        Pattern pat= Pattern.compile(pattern);
        if (passwordField1 == null) {
            passworderror.setVisible(true);
            return false;
        }

        boolean matches1 = pat.matcher(passwordField1.getText()).matches();
        if(matches1==false)
        {
            passworderror.setVisible(true);
        }
        return matches1;
    }


    private void emailidtextActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void AttachImage(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = ((File) f).getAbsolutePath();
        Idprooffield.setText(filename);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Shreeya Nelekar
        RegistrationPortal = new JLabel();
        Name = new JLabel();
        Email = new JLabel();
        Username = new JLabel();
        Password = new JLabel();
        Contact = new JLabel();
        emailidtext = new JFormattedTextField();
        usernametext = new JFormattedTextField();
        passwordField1 = new JPasswordField();
        contacttext = new JFormattedTextField();
        nametext = new JFormattedTextField();
        Address = new JLabel();
        addresstext = new JFormattedTextField();
        Register = new JButton();
        nameerror = new JLabel();
        emailerror = new JLabel();
        usernameerror = new JLabel();
        passworderror = new JLabel();
        contacterror = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        Idproof = new JLabel();
        label3 = new JLabel();
        Idprooffield = new JTextField();
        Attach = new JButton();

        //======== this ========
        setBackground(Color.white);
        setBorder(new MatteBorder(3, 3, 3, 3, Color.black));
        setForeground(Color.black);
        setAlignmentX(4.5F);
        setAlignmentY(8.5F);

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- RegistrationPortal ----
        RegistrationPortal.setText("REGISTRATION PORTAL");
        RegistrationPortal.setToolTipText("ds");
        RegistrationPortal.setHorizontalAlignment(SwingConstants.CENTER);
        RegistrationPortal.setFont(new Font("Baskerville Old Face", RegistrationPortal.getFont().getStyle() | Font.BOLD, RegistrationPortal.getFont().getSize() + 6));
        RegistrationPortal.setBackground(Color.white);
        RegistrationPortal.setForeground(new Color(51, 0, 51));

        //---- Name ----
        Name.setText("NAME:*");
        Name.setHorizontalAlignment(SwingConstants.LEFT);
        Name.setFont(Name.getFont().deriveFont(Name.getFont().getStyle() | Font.BOLD, Name.getFont().getSize() + 2f));
        Name.setForeground(Color.black);

        //---- Email ----
        Email.setText("E-MAIL ID:*");
        Email.setFont(Email.getFont().deriveFont(Email.getFont().getStyle() | Font.BOLD, Email.getFont().getSize() + 2f));
        Email.setHorizontalAlignment(SwingConstants.LEFT);
        Email.setForeground(Color.black);

        //---- Username ----
        Username.setText("USERNAME:*");
        Username.setHorizontalAlignment(SwingConstants.LEFT);
        Username.setFont(Username.getFont().deriveFont(Username.getFont().getStyle() | Font.BOLD, Username.getFont().getSize() + 2f));
        Username.setForeground(Color.black);

        //---- Password ----
        Password.setText("PASSWORD*:");
        Password.setHorizontalAlignment(SwingConstants.LEFT);
        Password.setFont(Password.getFont().deriveFont(Password.getFont().getStyle() | Font.BOLD, Password.getFont().getSize() + 2f));
        Password.setForeground(Color.black);

        //---- Contact ----
        Contact.setText("CONTACT NO:*");
        Contact.setFont(Contact.getFont().deriveFont(Contact.getFont().getStyle() | Font.BOLD, Contact.getFont().getSize() + 2f));
        Contact.setHorizontalAlignment(SwingConstants.LEFT);
        Contact.setForeground(Color.black);

        //---- emailidtext ----
        emailidtext.setBackground(Color.white);
        emailidtext.setForeground(Color.black);

        //---- usernametext ----
        usernametext.setBackground(Color.white);
        usernametext.setForeground(Color.black);

        //---- passwordField1 ----
        passwordField1.setBackground(Color.white);
        passwordField1.setForeground(Color.black);

        //---- contacttext ----
        contacttext.setBackground(Color.white);
        contacttext.setForeground(Color.black);

        //---- nametext ----
        nametext.setBackground(Color.white);
        nametext.setSelectionColor(Color.black);
        nametext.setCaretColor(Color.black);
        nametext.setDisabledTextColor(Color.black);
        nametext.setSelectedTextColor(Color.black);
        nametext.setForeground(Color.black);

        //---- Address ----
        Address.setText("ADDRESS:");
        Address.setForeground(Color.black);
        Address.setFont(Address.getFont().deriveFont(Address.getFont().getStyle() | Font.BOLD, Address.getFont().getSize() + 2f));

        //---- addresstext ----
        addresstext.setForeground(Color.black);
        addresstext.setBackground(Color.white);

        //---- Register ----
        Register.setText("REGISTER");
        Register.setBackground(new Color(0, 51, 102));
        Register.setFont(Register.getFont().deriveFont(Register.getFont().getStyle() | Font.BOLD, Register.getFont().getSize() + 2f));
        Register.setForeground(Color.white);
        Register.addActionListener(e -> RegisterActionPerformed(e));

        //---- nameerror ----
        nameerror.setText("Please enter name");
        nameerror.setBackground(Color.white);
        nameerror.setForeground(Color.red);
        nameerror.setFont(nameerror.getFont().deriveFont(nameerror.getFont().getStyle() | Font.BOLD, nameerror.getFont().getSize() + 1f));
        nameerror.setIcon(new ImageIcon("C:\\Users\\shreya\\HotelBookingPortal\\src\\bits\\oops\\project\\error.png"));

        //---- emailerror ----
        emailerror.setText("Please enter valid E-mail address.");
        emailerror.setFont(emailerror.getFont().deriveFont(emailerror.getFont().getStyle() | Font.BOLD, emailerror.getFont().getSize() + 1f));
        emailerror.setForeground(Color.red);
        emailerror.setIcon(new ImageIcon("C:\\Users\\shreya\\HotelBookingPortal\\src\\bits\\oops\\project\\error.png"));

        //---- usernameerror ----
        usernameerror.setText("Please enter username.");
        usernameerror.setFont(usernameerror.getFont().deriveFont(usernameerror.getFont().getStyle() | Font.BOLD, usernameerror.getFont().getSize() + 1f));
        usernameerror.setBackground(Color.white);
        usernameerror.setForeground(Color.red);
        usernameerror.setIcon(new ImageIcon("C:\\Users\\shreya\\HotelBookingPortal\\src\\bits\\oops\\project\\error.png"));

        //---- passworderror ----
        passworderror.setText("Please enter valid password");
        passworderror.setIcon(new ImageIcon("C:\\Users\\shreya\\HotelBookingPortal\\src\\bits\\oops\\project\\error.png"));
        passworderror.setForeground(Color.red);
        passworderror.setFont(passworderror.getFont().deriveFont(passworderror.getFont().getStyle() | Font.BOLD, passworderror.getFont().getSize() + 1f));

        //---- contacterror ----
        contacterror.setText("Please enter valid contact number.");
        contacterror.setBackground(Color.blue);
        contacterror.setForeground(Color.red);
        contacterror.setIcon(new ImageIcon("C:\\Users\\shreya\\HotelBookingPortal\\src\\bits\\oops\\project\\error.png"));
        contacterror.setFont(contacterror.getFont().deriveFont(contacterror.getFont().getStyle() | Font.BOLD, contacterror.getFont().getSize() + 1f));

        //---- label1 ----
        label1.setText("This username already exists.");
        label1.setBackground(Color.white);
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 1f));
        label1.setForeground(Color.red);
        label1.setIcon(new ImageIcon("C:\\Users\\shreya\\HotelBookingPortal\\src\\bits\\oops\\project\\error.png"));

        //---- label2 ----
        label2.setText("Congratulations! You have successfully registered.");
        label2.setForeground(new Color(51, 153, 0));
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 3f));

        //---- Idproof ----
        Idproof.setText("ID PROOF:");
        Idproof.setBackground(Color.white);
        Idproof.setFont(Idproof.getFont().deriveFont(Idproof.getFont().getStyle() | Font.BOLD, Idproof.getFont().getSize() + 2f));
        Idproof.setForeground(Color.black);

        //---- label3 ----
        label3.setText("Upload the image here.");
        label3.setBackground(Color.white);
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        label3.setForeground(new Color(0, 0, 102));

        //---- Idprooffield ----
        Idprooffield.setBackground(Color.white);
        Idprooffield.setForeground(Color.black);
        Idprooffield.setFont(Idprooffield.getFont().deriveFont(Idprooffield.getFont().getSize() + 2f));

        //---- Attach ----
        Attach.setText("ATTACH");
        Attach.setBackground(new Color(0, 51, 102));
        Attach.setFont(Attach.getFont().deriveFont(Attach.getFont().getStyle() | Font.BOLD, Attach.getFont().getSize() + 2f));
        Attach.setForeground(Color.white);
        Attach.addActionListener(e -> AttachImage(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup()
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(Register)
                                .addGap(18, 18, 18)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(Name, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nametext, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(RegistrationPortal, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Contact, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Username)
                                            .addComponent(Password, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Address, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Idproof, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(Email, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(passwordField1, GroupLayout.Alignment.LEADING)
                                    .addComponent(usernametext, GroupLayout.Alignment.LEADING)
                                    .addComponent(emailidtext)
                                    .addComponent(contacttext)
                                    .addComponent(addresstext, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(label3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(Idprooffield, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(Attach, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))))
                    .addGap(44, 44, 44)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(nameerror, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addComponent(emailerror, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addComponent(usernameerror, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(passworderror, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(contacterror, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                            .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(RegistrationPortal, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Name, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameerror)
                        .addComponent(nametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(emailidtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Email, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailerror))
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Username, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addComponent(usernametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(usernameerror))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(Password, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passworderror)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Contact, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(contacttext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(contacterror))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Address, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addresstext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(Idproof, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Idprooffield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Attach)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Register)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label2)
                    .addGap(117, 117, 117))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Shreeya Nelekar
    private JLabel RegistrationPortal;
    private JLabel Name;
    private JLabel Email;
    private JLabel Username;
    private JLabel Password;
    private JLabel Contact;
    private JFormattedTextField emailidtext;
    private JFormattedTextField usernametext;
    private JPasswordField passwordField1;
    private JFormattedTextField contacttext;
    private JFormattedTextField nametext;
    private JLabel Address;
    private JFormattedTextField addresstext;
    private JButton Register;
    private JLabel nameerror;
    private JLabel emailerror;
    private JLabel usernameerror;
    private JLabel passworderror;
    private JLabel contacterror;
    private JLabel label1;
    private JLabel label2;
    private JLabel Idproof;
    private JLabel label3;
    private JTextField Idprooffield;
    private JButton Attach;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    User registeredUser;
}
