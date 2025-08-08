function Pattern(num)
{

    var s = "";

    for(let i = 1 ; i <= num ; i++)
    {
        for(let j=1; j<= i;j++)
        {
            s += j;
        }

        if(i !=num )
        {
            s += "\n";
        }

    }
    return s;
}


console.log(Pattern(5));
