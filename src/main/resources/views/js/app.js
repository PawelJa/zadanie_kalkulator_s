API_URL = "http://localhost:8080/";

$(document).ready(function () {
    getCountries();

    function getCountries() {
        $.ajax({
            url: API_URL + "country"
        }).done(function (countries) {
            console.log(countries);
            showCountries(countries);
        })
    }

    function showCountries(countries) {
        var select = $('input.countries')

        countries.forEach()
    }
})

