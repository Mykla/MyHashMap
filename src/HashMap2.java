import java.util.LinkedList;

public class HashMap2<K, V> {
    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    // ------------------------------------------------------- //

    private Object[] arr = new Object[16];

    public boolean contansKey(K key) {
        return get(key) != null;
    }

    public int size() {
        LinkedList<Entry<K, V>> list;
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            list = (LinkedList<Entry<K, V>>) arr[i];
            if (list != null)
                res += list.size();
        }

        return res;
    }

    public void put(K key, V value) {
        Entry<K, V> e = new Entry<K, V>(key, value);

        int hashCode = key.hashCode();
        int n = Math.abs(hashCode % arr.length);

        if (arr[n] == null)
            arr[n] = new LinkedList<Entry<K, V>>();

        LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) arr[n];

        for (int i = 0; i < list.size(); i++) {
            Entry<K, V> entry = list.get(i);
            if (entry.getKey().equals(e.getKey())) {
                entry.setValue(e.getValue());
                return;
            }
        }

        list.add(e);
    }

    public V get(K key) {
        int hashCode = key.hashCode();
        int n = Math.abs(hashCode % arr.length);

        if (arr[n] == null)
            return null;

        LinkedList<Entry<K, V>> list = (LinkedList<Entry<K, V>>) arr[n];

        for (int i = 0; i < list.size(); i++) {
            Entry<K, V> entry = list.get(i);
            if (entry.getKey().equals(key))
                return entry.getValue();
        }

        return null;
    }
}
