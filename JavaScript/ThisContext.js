class ThisContext {

    constructor(name)
    {
        this.name=name;
        this.count=0;
    }


     returnName()
    {
        return this.name;
    }

    increment()
    {
        return this.count + 1;
    }
    //render is an instance method and is stored on the prototype object
    //There is no auto-resolve in javaScript unlike java , so javaScript cannot implicitly look
    // for properties/fields in the objects on which the method is called
    //so javaScript without the this keyword will look for local variables/variables in stack frame
    //which is why in order to use object properties we have to use this.property/FieldName inside methods
    render()
    {
       console.log("Rendered by  Object : " + this.returnName() + "   render()'s object is :" + this.name);
    }


    nestedIncrement()
    {
       return  this.increment();
    }

}


c = new ThisContext("Bishal");

c.render();

console.log(c.nestedIncrement());