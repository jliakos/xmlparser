package parser;

import junit.framework.TestCase;
import org.junit.Test;

import static parser.StringXMLParser.DELIMITER;

public class StringXMLParserTest extends TestCase {
	final StringXMLParser parser = new StringXMLParser();
	final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<breakfast_menu>\n" +
			"  <food>\n" +
			"    <name>Belgian Waffles</name>\n" +
			"    <price>$5.95</price>\n" +
			"    <description>Two of our famous Belgian Waffles with plenty of real maple syrup</description>\n" +
			"    <calories>650</calories>\n" +
			"  </food>\n" +
			"  <food>\n" +
			"    <name>Strawberry Belgian Waffles</name>\n" +
			"    <price>$7.95</price>\n" +
			"    <description>Light Belgian waffles covered with strawberries and whipped cream</description>\n" +
			"    <calories>900</calories>\n" +
			"  </food>\n" +
			"  <food>\n" +
			"    <name>Berry-Berry Belgian Waffles</name>\n" +
			"    <price>$8.95</price>\n" +
			"    <description>Light Belgian waffles covered with an assortment of fresh berries and whipped cream</description>\n" +
			"    <calories>900</calories>\n" +
			"  </food>\n" +
			"  <food>\n" +
			"    <name>French Toast</name>\n" +
			"    <price>$4.50</price>\n" +
			"    <description>Thick slices made from our homemade sourdough bread</description>\n" +
			"    <calories>600</calories>\n" +
			"  </food>\n" +
			"  <food>\n" +
			"    <name>Homestyle Breakfast</name>\n" +
			"    <price>$6.95</price>\n" +
			"    <description>Two eggs, bacon or sausage, toast, and our ever-popular hash browns</description>\n" +
			"    <calories>950</calories>\n" +
			"  </food>\n" +
			"</breakfast_menu>";


	@Test
	public void testPrice() {


		String result = parser.parse(xml,
				"food" + DELIMITER + "<name>Strawberry Belgian Waffles" + DELIMITER + "price");
		assertEquals(result, "$7.95");

		result = parser.parse(xml,
				"food" + DELIMITER + "<name>French Toast" + DELIMITER + "price");
		assertEquals(result, "$4.50");

		result = parser.parse(xml,
				"food" + DELIMITER + "<name>Homestyle Breakfast" + DELIMITER + "price");
		assertEquals(result, "$6.95");

	}

	@Test
	public void testCalories() {


		String result = parser.parse(xml,
				"food" + DELIMITER + "<name>Strawberry Belgian Waffles" + DELIMITER + "calories");
		assertEquals(result, "900");

		result = parser.parse(xml,
				"food" + DELIMITER + "<name>French Toast" + DELIMITER + "calories");
		assertEquals(result, "600");

		result = parser.parse(xml,
				"food" + DELIMITER + "<name>Homestyle Breakfast" + DELIMITER + "calories");
		assertEquals(result, "950");

	}

	@Test
	public void testDescription() {


		String result = parser.parse(xml,
				"food" + DELIMITER + "<name>Strawberry Belgian Waffles" + DELIMITER + "description");
		assertEquals(result, "Light Belgian waffles covered with strawberries and whipped cream");

		result = parser.parse(xml,
				"food" + DELIMITER + "<name>French Toast" + DELIMITER + "description");
		assertEquals(result, "Thick slices made from our homemade sourdough bread");

		result = parser.parse(xml,
				"food" + DELIMITER + "<name>Homestyle Breakfast" + DELIMITER + "description");
		assertEquals(result, "Two eggs, bacon or sausage, toast, and our ever-popular hash browns");

	}
}