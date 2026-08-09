// function that show what we want and hide what we don't
function Show(SectionId){
    const sections = ["Addaction","Searchaction","showlist","Deleteaction","searchtarget"];
    sections.forEach(sId => {
        if(sId === SectionId){
            document.getElementById(sId).style.display = "block";
        }
         else {document.getElementById(sId).style.display = "none";}
    });
}

// fetch add
function fetchAdd(){
    let name = document.getElementById("nameI").value;
    let number = document.getElementById("numberI").value;
    let email = document.getElementById("emailI").value;
    let User = {
        name : name,
        number : number,
        email : email
    };
    fetch("http://127.0.0.1:7070/contact/add",{
        method : "POST",
        headers : {
            "Content-Type" : "application/json"
        },
        body : JSON.stringify(User)
    })
    .then(response => {
        return response.json();
    })
    .then(output => {
        console.log(output);
        fetchList();

    });
}
// fetch list
function fetchList(){
    let i = 1;
    let okk = false;
    const container = document.getElementById("showlist");
    const h1 = document.createElement('h1');
    h1.textContent = "Root's contact : ";
    h1.className = "myclass";
    container.innerHTML = '';
    container.appendChild(h1);
    fetch("http://127.0.0.1:7070/contact")
    .then(response => {
        if(response.status === 200) okk = true;
        return response.json();
    })
    .then(data => {
        if(!okk){
            const div = document.createElement('div');
            div.textContent = data.error;
            div.style.fontSize = "40px";
            container.appendChild(div);
            return;
        }
        data.forEach(ct =>{
            const div = document.createElement('div');
            div.className = "myclass2"
            div.textContent = i + " " + ct.name;
            container.appendChild(div);
            i++;
        })
    });
}
//feth list
function fetchSearch(){
    let name = document.getElementById("SearchI").value;
    let div = document.createElement('div');
    let container = document.getElementById("searchtarget");
    container.innerHTML = '';
    fetch("http://127.0.0.1:7070/contact/search?name=" + name)
    .then(response => {
        return response.json();
    })
    .then(data => {
        div.textContent = data.name;
        container.appendChild(div);
    })
}