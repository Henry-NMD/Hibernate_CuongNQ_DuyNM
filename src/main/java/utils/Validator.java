package utils;

import java.util.List;

public class Validator {
    /**
     * this method is checked if the customer id exits in the list or not
     *
     * @param true if duplicate date , otherwise fail
     * @param id
     * @return true if customer id is exits , otherwise false
     */
    public static boolean checkIdExist(final List<Integer> listId, int id) {
        boolean check = false;
        if (listId.isEmpty() || listId == null) {
            return false;
        } else{
            check = listId.stream().anyMatch((Integer integer) -> id == integer);
        }
        return check;
    }
}
