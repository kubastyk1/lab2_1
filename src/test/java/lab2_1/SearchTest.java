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

	@Test
	public void objectIsNotInSequenceTest() {
		int[] seq = {5};
		int key = 77;
		int position = -1;

		SearchResult searchResult = BinarySearch.search(key, seq);

		assertThat(searchResult.isFound(), is(not(true)));
		assertThat(searchResult.getPosition(), is(equalTo(position)));
	}
	
	@Test
	public void objectIsFirstElementTest() {
		int[] seq = {1,2,3,4,5,6,7,8,9,10};
		int key = 1;
		int position = 0;

		SearchResult searchResult = BinarySearch.search(key, seq);

		assertThat(searchResult.isFound(), is(true));
		assertThat(searchResult.getPosition(), is(equalTo(position)));
		assertThat(seq[position], is(equalTo(key)));
	}
	
	@Test
	public void objectIsLastElementTest() {
		int[] seq = {1,2,3,4,5,6,7,8,9,10};
		int key = 10;
		int position = seq.length - 1;

		SearchResult searchResult = BinarySearch.search(key, seq);

		assertThat(searchResult.isFound(), is(true));
		assertThat(searchResult.getPosition(), is(equalTo(position)));
		assertThat(seq[position], is(equalTo(key)));
	}
	
	@Test
	public void objectIsMiddleElementTest() {
		int[] seq = {1,2,3,4,5,6,7,8,9};
		int key = 5;
		int position = seq.length/2;

		SearchResult searchResult = BinarySearch.search(key, seq);

		assertThat(searchResult.isFound(), is(true));
		assertThat(searchResult.getPosition(), is(equalTo(position)));
		assertThat(seq[position], is(equalTo(key)));
	}
}
