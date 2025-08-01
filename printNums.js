function generateNumberPattern(n) {
    //Write your code here

    var string = "";


    for(let i = 1 ; i <= n ; i++)
    {

        var k = i;

        for( let j = 1 ; j <= k ; j++)
        {
            string += ""+j ;
        }

        if( i != n )
        {
        string += "\n";
            }




    }
    return string;

}

console.log(generateNumberPattern(6));
