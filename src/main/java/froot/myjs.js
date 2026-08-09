/* this part of code , show you just the section you need ( when you click search contact it show you only 
search contact and not anything else ( delete , list , add ... )) */
document.getElementById("Add").addEventListener("click", () => Show("Addaction"));
document.getElementById("Search").addEventListener("click", () => Show("Searchaction"));
document.getElementById("Delete").addEventListener("click", () => Show("Deleteaction"));
document.getElementById("List").addEventListener("click", () => Show("showlist"));
document.getElementById("searchclick").addEventListener("click", () => Show("searchtarget"));

// server part :
// Add Contact
let addBtn = document.getElementById("addclick");
addBtn.addEventListener("click",() => {
    fetchAdd();
    addBtn.addEventListener("click", () => Show("showlist"));
})

// fetch for list
let listBtn = document.getElementById("List");
listBtn.addEventListener("click",() => {
    fetchList();
})
// sesarch fetch
let searchBtn = document.getElementById("searchclick");
searchBtn.addEventListener("click",() => {
    fetchSearch();
})