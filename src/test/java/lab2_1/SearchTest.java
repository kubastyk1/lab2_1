package lab2_1;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class SearchTest {

	@Test
	public void objectIsInSequenceTest() {
		int[] seq = {5};
		int key = 5;
		int position = 0;

		SearchResult searchResult = BinarySearch.search(key, seq);

		assertThat(searchResult.isFound(), is(true));
		assertThat(searchResult.getPosition(), is(equalTo(position)));
		assertThat(seq[position], is(equalTo(key)));
	}

}
