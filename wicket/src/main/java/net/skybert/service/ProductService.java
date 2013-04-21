package net.skybert.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import net.skybert.model.Product;

/**
 * ProductService
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class ProductService implements Serializable {
	private static final long serialVersionUID = 1L;

	final static Map<Integer, Product> sProductMap = new HashMap<>();

	static {
		sProductMap.put(1, new Product(1, "Book", 10d));
		sProductMap.put(2, new Product(2, "Ice cream", 11d));
		sProductMap.put(3, new Product(3, "Sandwhich", 23d));
	}

	public Product get(final int pProductId) {
		return sProductMap.get(pProductId);
	}

}