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
	public void objectIsNotFirstElementTest() {
		int[] seq = {1,2,3,4,5,6,7,8,9,10};
		int key = 4;
		int position = 0;

		SearchResult searchResult = BinarySearch.search(key, seq);

		assertThat(searchResult.isFound(), is(true));
		assertThat(searchResult.getPosition(), is(not(equalTo(position))));
		assertThat(seq[position], is(not(equalTo(key))));
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
	public void objectIsNotLastElementTest() {
		int[] seq = {1,2,3,4,5,6,7,8,9,10};
		int key = 6;
		int position = seq.length - 1;

		SearchResult searchResult = BinarySearch.search(key, seq);

		assertThat(searchResult.isFound(), is(true));
		assertThat(searchResult.getPosition(), is(not(equalTo(position))));
		assertThat(seq[position], is(not(equalTo(key))));
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

	@Test
	public void objectIsNotInSequenceManyObjectsTest() {
		int[] seq = {1,2,3,4,5,6,7,8,9};
		int key = 77;
		int position = -1;

		SearchResult searchResult = BinarySearch.search(key, seq);

		assertThat(searchResult.isFound(), is(not(true)));
		assertThat(searchResult.getPosition(), is(equalTo(position)));
	}

	@Test
	public void sequenceIsEmptyTest() {
		int[] seq = {};
		int key = 5;

		try {
			SearchResult searchResult = BinarySearch.search(key, seq);
		} catch (IllegalArgumentException anIllegalArgumentException) {
	        assertThat(anIllegalArgumentException.getMessage(), is("Error!"));
	    }

		assertThat(seq.length, is(0));
	}
	
	@Test
	public void objectIsInFirstPartOfSequenceTest() {
		int[] seq = {1,2,3,4,5,6,7,8,9};
		int key = 2;
		int position = 1;
		int middle = seq.length/2;
		boolean isInFirstPart = false;

		SearchResult searchResult = BinarySearch.search(key, seq);

		if(key < middle)
			isInFirstPart = true;

		assertThat(searchResult.isFound(), is(true));
		assertThat(searchResult.getPosition(), is(equalTo(position)));
		assertThat(seq[position], is(equalTo(key)));

		assertThat(isInFirstPart, is(true));
	}
	
	@Test
	public void objectIsInSecondPartOfSequenceTest() {
		int[] seq = {1,2,3,4,5,6,7,8,9};
		int key = 8;
		int position = 7;
		int middle = seq.length/2;
		boolean isInSecondPart = false;

		SearchResult searchResult = BinarySearch.search(key, seq);

		if(key > middle)
			isInSecondPart = true;

		assertThat(searchResult.isFound(), is(true));
		assertThat(searchResult.getPosition(), is(equalTo(position)));
		assertThat(seq[position], is(equalTo(key)));

		assertThat(isInSecondPart, is(true));
	}
}
