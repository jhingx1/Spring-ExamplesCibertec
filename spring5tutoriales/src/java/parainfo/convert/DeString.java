package parainfo.convert;

/**
 * @author parainformaticos.com
 */
public class DeString {

    public DeString() {
    }

    public static Integer aInteger(String s) {
        Integer result = null;

        try {
            result = Integer.valueOf(s);
        } catch (NumberFormatException ex) {
        }

        return result;
    }

    public static Double aDouble(String s) {
        Double result = null;

        if (s != null) {
            try {
                result = Double.valueOf(s);
            } catch (NumberFormatException ex) {
            }
        }

        return result;
    }

    /**
     * @param _ids cadena == "3,4,7,8,9"
     * @return arreglo de enteros
     */
    public static Integer[] ids(String _ids) {
        Integer[] v_id = null;

        if ((_ids != null) && (_ids.trim().length() > 0)) {

            String[] id = _ids.split(",");
            v_id = new Integer[id.length];

            for (int i = 0; i < id.length; i++) {
                v_id[i] = aInteger(id[i]);

                if (v_id[i] == null) {
                    v_id = null;
                    break;
                }
            }
        }

        return v_id;
    }
}

