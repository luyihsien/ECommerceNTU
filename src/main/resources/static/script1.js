document.addEventListener("DOMContentLoaded", function() {
const productData = [
{
id: 1,
name: "Cake",
price: 49.99,
image: "./assets/img/cake.jpg"
},
{
id: 2,
name: "Coffee",
price: 59.99,
image: "./assets/img/Coffee.jpg"
}
// Add more products here
];

const productGrid = document.querySelector(".product-grid");

productData.forEach(product => {
const productCard = document.createElement("div");
productCard.classList.add("product-card");
productCard.innerHTML = `
<img class="product-image" src="${product.image}" alt="${product.name}">
<h3>${product.name}</h3>
<p>$${product.price.toFixed(2)}</p>
<button class="add-to-cart">Add to Cart</button>
`;
productGrid.appendChild(productCard);
    // Add an event listener to the "Add to Cart" button
const addToCartButton = productCard.querySelector(".add-to-cart");
addToCartButton.addEventListener("click", () => {
alert("測試");
addToCart(product);
});

});
});
// Function to send a POST request to the Spring Boot application
// Function to send a POST request to the Spring Boot application
//function addToCart(product) {
//    fetch('/api/cart', {
//        method: 'POST',
//        headers: {
//            'Content-Type': 'application/json'
//        },
//        body: JSON.stringify(product)
//    }).then(response => {
//        if (response.ok) {
//            console.log('Product added to cart:', product.name);
//        } else {
//            console.error('Error adding product to cart:', product.name);
//        }
//    }).catch(error => {
//        console.error('Error adding product to cart:', product.name, error);
//    });
//}
function addToCart(product) {
    fetch('/api/cart', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    })
    .then(response => {
        response.text().then(text => {
            if (response.ok) {
                alert(text); //顯示成功消息
            } else {
                alert("Error: " + text); // 顯示失敗消息
            }
        });
    })
    .catch(error => {
        console.error('Error adding product to cart:', product.name, error);
        alert('Error adding product to cart: ' + product.name);
    });
}
