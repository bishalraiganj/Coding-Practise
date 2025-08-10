function Test(name)
{
    //This is a instance field of Test type stored on each particular instance
    this.name = name;

    //instance field/var/property storing a function;
    this.fu= function ()
    {};

}

//Instance method of the Test type on it's prototype
Test.prototype.getName = function()
{
    return this.name;
}
Test.staticMethodName = function()
{
    console.log("This is a static method ");
}
const bishal = new Test("Bishal Adhikary");

console.log(bishal.name);