# headlines
Spring Boot app that provides a RESTful API to read news headlines from newsapi.org

<p>This Spring Boot Application contains two web services</p>
<ul>
  <li>Top Headlines - To Fetch Top Headlines only</li>
  <li>Everything - To Fetch everything in News</li>
</ul>

In target folder, you will find <b>Headlines-0.0.1-SNAPSHOT.jar</b>.
You can deploy the web service on your system <code>java -jar Headlines-0.0.1-SNAPSHOT.jar</code>.
<H4>Prerequisite</h4>
Java 1.8

<h2>Top Headline Service</h2>
<code>/timesinternet/topheadlines</code>
<h3>Request parameters</h3>
<table>
<tr>
<th>Name</th>
<th>Description</th>
</tr>
<tr>
<td>country</td>
<td>The 2-letter ISO 3166-1 code of the country you want to get headlines for. Possible options: ae ar at au be bg br ca ch cn co cu cz de eg fr gb gr hk hu id ie il in it jp kr lt lv ma mx my ng nl no nz ph pl pt ro rs ru sa se sg si sk th tr tw ua us ve za . Note: you can't mix this param with the sources param.</td>
</tr>
</tr>
<tr>
<td>category</td>
<td>he category you want to get headlines for. Possible options: business entertainment general health science sports technology . Note: you can't mix this param with the sources param.</td>
</tr>
</tr>
<tr>
<td>sources</td>
<td>A comma-seperated string of identifiers for the news sources or blogs you want headlines from. Use the /sources endpoint to locate these programmatically or look at the sources index. Note: you can't mix this param with the country or category params.</td>
</tr>
<tr>
<td>query</td>
<td>Keywords or a phrase to search for.</td>
</tr>
</table>
