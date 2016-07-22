package by.it.novik.jd03_03.dao;

/**
 * Created by Kate Novik.
 */
public class DAO {
    //Объект сингелтон DAO
    private static DAO dao;
    //Поля конкретных DAO
    private UserDAO userDAO;
    private RoleDAO roleDAO;
    private AccountDAO accountDAO;
    private PaymentDAO paymentDAO;
    private AllUsersWithRolesDAO allUsersWithRolesDAO;

    private DAO (){}

    /**
     * Создание объекта DAO c инициализацией полей (конкретными типами DAO)
     * @return Объект DAO
     */
    public static DAO getDAO () {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null){
                    dao = new DAO();
                    dao.userDAO = new UserDAO();
                    dao.roleDAO = new RoleDAO();
                    dao.accountDAO = new AccountDAO();
                    dao.paymentDAO = new PaymentDAO ();
                    dao.allUsersWithRolesDAO = new AllUsersWithRolesDAO();
                }
            }
        }
        return dao;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public PaymentDAO getPaymentDAO() {
        return paymentDAO;
    }

    public AllUsersWithRolesDAO getAllUsersWithRolesDAO() {
        return allUsersWithRolesDAO;
    }
}
