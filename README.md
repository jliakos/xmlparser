# xmlparser
A simple String xml parser in Java


String parsing for efficiency for most types of xml.

Usage:

String result = new StringXMLParser().parse(xml,
				"searchTerm//child"); or
        
String result = new StringXMLParser().parse(xml,
				"searchTerm");
		
Example xml:
```md

<result>
<id>1</id>
<amount>10</amount>
</result>
```

Let's say we want to read the amount tag:
String result = new StringXMLParser().parse(xml,
				"amount");
				
or
String result = new StringXMLParser().parse(xml,
                				"result//amount");

					
				
