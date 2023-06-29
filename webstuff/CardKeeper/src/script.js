
fetch('http://localhost:8080/cards')
.then(res => res.json())
.then(data => {
    let cardData = data;
    data.map(function(cardData){
        let main = document.getElementById("mainRow")
 
        let col = document.createElement("div");
        let card = document.createElement("div")
        let cardBody = document.createElement("div");
        
        let cardName = document.createElement("p")
        let cardCode = document.createElement("p")
        let cardsAmount = document.createElement("p")
        let cardQuality = document.createElement("p")
        
        cardName.innerHTML = `Name: ${cardData.cardName}`
        cardCode.innerHTML = `Code: ${cardData.cardCode}`
        cardsAmount.innerHTML = `Number of cards: ${cardData.cardsAmount}`
        cardQuality.innerHTML = `Card Quality: ${cardData.cardQuality}`
        col.classList.add("col-2")
        col.classList.add("text-center")
        card.classList.add("card")
        card.classList.add("bg-light")
        cardBody.classList.add("card-body")
       
        cardBody.appendChild(cardName)
        cardBody.appendChild(cardCode)
        cardBody.appendChild(cardsAmount)
        cardBody.appendChild(cardQuality)

        card.appendChild(cardBody)
        col.appendChild(card)
        main.appendChild(col)
    })
})
