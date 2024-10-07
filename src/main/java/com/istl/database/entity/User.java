/*    */
package com.istl.database.entity;
/*    */
/*    */

import com.istl.database.entity.EmployeeRecord;
import lombok.Builder;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
/*    */ import javax.persistence.*;
/*    */
/*    */
import javax.validation.constraints.NotNull;

/*    */
/*    */
@Entity
@Builder
/*    */
@Table(name = "users")
/*    */ public class User {
    /*    */
    @Id
    /*    */
    @Column(name = "id")
    /*    */ private Long id;
    /*    */
    @Column(length = 50, name = "username")
    /*    */ private String username;
    /*    */
    @Column(length = 50, name = "password")
    /*    */ private String password;

    /*    */
    /* 19 */
    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "is_email_verified", columnDefinition = "TINYINT(4)")
    private Boolean authenticated;
    @Column(length = 255, name = "email_verify_code")
    private String confirmationCode;
    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_record_id", referencedColumnName = "ID")
    private EmployeeRecord employeeRecord;
    @Column(name = "is_admin")
    private Boolean isAdmin;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthenticated(@NotNull Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public void setEmployeeRecord(EmployeeRecord employeeRecord) {
        this.employeeRecord = employeeRecord;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public User()
    /*    */ {
        /* 48 */
        this
                /* 49 */.isAdmin = Boolean.valueOf(false);
    }

    public User(Long id, String username, String password, @NotNull Boolean authenticated, String confirmationCode, EmployeeRecord employeeRecord, Boolean isAdmin) {
        this.isAdmin = Boolean.valueOf(false);
        this.id = id;
        this.username = username;
        this.password = password;
        this.authenticated = authenticated;
        this.confirmationCode = confirmationCode;
        this.employeeRecord = employeeRecord;
        this.isAdmin = isAdmin;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    /*    */
    /*    */
    /*    */
    public Long getId() {
        /*    */
        return this.id;
        /*    */
    }

    /*    */
    /*    */
    public String getUsername() {
        /*    */
        return this.username;
        /*    */
    }

    /*    */
    /*    */
    public String getPassword() {
        /*    */
        return this.password;
        /*    */
    }

    /*    */
    /*    */
    @NotNull
    /*    */ public Boolean getAuthenticated() {
        /*    */
        return this.authenticated;
        /*    */
    }

    /*    */
    /*    */
    public String getConfirmationCode() {
        /*    */
        return this.confirmationCode;
        /*    */
    }

    /*    */
    /*    */
    public EmployeeRecord getEmployeeRecord() {
        /*    */
        return this.employeeRecord;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\User.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */