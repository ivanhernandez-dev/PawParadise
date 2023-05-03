function getCategoryTree(allCategories, language) {
    let list = "<ul>";
    for (let i = 0; i < allCategories.length; i++) {
        let enlace = `/${language}/categorias/${allCategories[i].id}`;
        list += `<li><a href="${enlace}">${allCategories[i].name}</a>`;
        if (allCategories[i].categories !== null) {
            list += getCategoryTree(allCategories[i].categories, language);
        }
        list += "</li>";
    }
    list += "</ul>";
    document.getElementById("allCategories").innerHTML = list;
    return list;
}