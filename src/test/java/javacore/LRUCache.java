package javacore;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {
	
	private final int CACHE_SIZE;
	
	public LRUCache(int cacheSize) {
		// true ��ʾ�� linkedHashMap ���շ���˳������������������ʵķ���ͷ�������Ϸ��ʵķ���β����
		super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
		CACHE_SIZE = cacheSize;
	}
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		//// �� map�е�����������ָ���Ļ��������ʱ�򣬾��Զ�ɾ�����ϵ����ݡ�
		return size()>CACHE_SIZE;
	}
	
	
	public static void main(String[] args) {
		LRUCache<String, Integer> cache = new LRUCache<>(4);
		cache.put("1", 1);
		cache.put("2", 2);
		cache.put("3", 3);
		cache.put("4", 4);
		cache.put("5", 5);
		cache.put("6", 6);
		cache.put("7", 7);
		cache.put("8", 8);
		cache.put("9", 9);
		
		Integer val_8 = cache.get("8");
		Integer val_9 = cache.get("9");
		Integer val_11 = cache.get("1");
		Integer val_111 = cache.get("1");
		Integer val_11111= cache.get("1");
		Integer val_111111 = cache.get("1");
		
		Set<java.util.Map.Entry<String, Integer>> entrySet2 = cache.entrySet();
		Iterator<java.util.Map.Entry<String, Integer>> iterator = entrySet2.iterator();
		while(iterator.hasNext()) {
			java.util.Map.Entry<String, Integer> next = iterator.next();
			System.out.println(next.getKey()+"-->"+next.getValue());
		}
		
		
	}
}
