API_URL = "http://localhost:8080/";

$(document).ready(function () {

    $('button').on('click', function (e) {
        getEarnedMoney(e);
    })

    getCountries();


    function getCountries() {
        $.ajax({
            url: API_URL + "country"
        }).done(function (countries) {
            showCountries(countries)
        })
    }

    function showCountries(countries) {
        var select = $('select')

        countries.forEach( function (e) {
            select.append("<option value='" + e.id + "'>" + e.fullName + "</option>");
        })
    }

    function getEarnedMoney(e) {
        e.preventDefault();

        var selectedId = $('select').val();
        var value = $('#payRate').val();


        if ($.isNumeric(value) && value > 0) {
            $('#error').text('');

            $.ajax({
                url: API_URL + "country"
            }).done(function (countries) {
                var result = countries.find(x => x.id === selectedId);

                var objToSend = {
                    id : result.id,
                    fullName : result.fullName,
                    oncost : result.oncost,
                    taxPercent : result.taxPercent,
                    currency : result.currency
                }
                var headers = new Headers({
                    'Content-Type': 'application/json'
                });

                var myInit = {
                    method: 'POST',
                    headers: headers,
                    cache: 'default',
                    body: JSON.stringify(objToSend)
                };



                fetch(API_URL+'/earnings/' + value, myInit).then(resp => resp.json()).then(resp => {
                    var earnings = $('#earnings')
                    earnings.empty()
                    earnings.append('<div class="earningsChild">Your earnings:</div><br>');
                if (resp.value < 0) {
                    earnings.append('<div class="earningsChild"> Not good... You earn less money then your costs are')
                }
                    earnings.append('<div class="earningsChild">' + resp.value + ' PLN</div>')
                    earnings.append('<div class="earningsChild">Used rate from: ' + resp.date + '</div>');
                });

            })
        } else {
            $('#error').text("Wrong value :( . It must be numeric and positive ;)");
        }


    }
})

