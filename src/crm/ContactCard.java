/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crm;

import java.awt.Panel;
import javax.swing.*;
import org.omg.PortableInterceptor.NON_EXISTENT;


/**
 *
 * @author kexital
 */
public class ContactCard extends JPanel {
//  card fields labels:
        JLabel firstNameLabel = new JLabel("Имя");
        JLabel lastNameLabel = new JLabel("Фамилия");
        JLabel fatherNameLabel = new JLabel("Отчество");
        JLabel telLabel = new JLabel("тел.");
        JLabel emailLabel = new JLabel("e-mail");
        JLabel departmentLabel = new JLabel("Отдел");
        JLabel positionLabel = new JLabel("Должность");
        JLabel creatorLabel = new JLabel("Создатель");
       
//      contact's data. By default initialized with "No contacts" to provide 
//      more user-friendly information to nonexperienced user in case if no firm
//      contacts exist or card initialized with default
        JLabel firstName = new JLabel();
        JLabel lastName = new JLabel();
        JLabel fatherName = new JLabel();
        JLabel tel = new JLabel();
        JLabel email = new JLabel();
        JLabel department = new JLabel();
        JLabel position = new JLabel();
        JLabel creator = new JLabel();

//  card buttons:        
        JButton editButton = new JButton("Edit");
        JButton delButton = new JButton("Delete");
        
        
        
        
        
        
    public ContactCard() {
        firstName.setText("-");
        lastName.setText("-");
        fatherName.setText("-");
        tel.setText("-");
        email.setText("-");
        department.setText("-");
        position.setText("-");
        creator.setText("-");
        
        initComponents();
        
    }
    
    public ContactCard ( String firstName,
                         String lastName,
                         String fatherName,
                         String tel,
                         String email,
                         String department,
                         String position,
                         String creator ) {
       // super();
        initComponents();
    }
    
    private void initComponents() {
        this.setBorder(BorderFactory.createEtchedBorder(WIDTH));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(firstNameLabel)
                        .addComponent(lastNameLabel)
                        .addComponent(fatherNameLabel)
                        .addComponent(telLabel)
                        .addComponent(emailLabel)
                        .addComponent(departmentLabel)
                        .addComponent(positionLabel)
                        .addComponent(creatorLabel)
                        .addComponent(editButton)
                        .addComponent(delButton)
                    )
                    
                    .addGroup(layout.createParallelGroup()
                        .addComponent(firstName)
                        .addComponent(lastName)
                        .addComponent(fatherNameLabel)
                        .addComponent(tel)
                        .addComponent(email)
                        .addComponent(department)
                        .addComponent(position)
                        .addComponent(creator)
                    )
                    
                
                
                );

        layout.setVerticalGroup(
                layout.createParallelGroup()
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstNameLabel)
                        .addComponent(lastNameLabel)
                        .addComponent(fatherNameLabel)
                        .addComponent(telLabel)
                        .addComponent(emailLabel)
                        .addComponent(departmentLabel)
                        .addComponent(positionLabel)
                        .addComponent(creatorLabel)
                        .addComponent(editButton)
                        .addComponent(delButton)
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstName)
                        .addComponent(lastName)
                        .addComponent(fatherNameLabel)
                        .addComponent(tel)
                        .addComponent(email)
                        .addComponent(department)
                        .addComponent(position)
                        .addComponent(creator)
                
                    )
                );
        
        
        
      
        
       
    }
    
    public void getEmptyCard() {
        firstName.setText("-");
        lastName.setText("-");
        fatherName.setText("-");
        tel.setText("-");
        email.setText("-");
        department.setText("-");
        position.setText("-");
        creator.setText("-");
        
    }
    

}
