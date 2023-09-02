fun main(){ 
	val youtubeVideLink = "https://youtu.be/cY4HiiFHO1o"
	println(""" 
Prints a formatted matrix of 4 rows and 4 columns
using the values from this example of TSP
link to the video $youtubeVideLink
""")
	val row001 = "0 \t 4 \t 1 \t 9  \n"
	val row002 = "3 \t 0 \t 6 \t 11 \n"
	val row003 = "4 \t 1 \t 0 \t 2  \n"
	val row004 = "6 \t 5 \t -4\t 0  \n"
	
	val matrix4by4 = row001 + row002 + row003 + row004
	println(matrix4by4)
}

