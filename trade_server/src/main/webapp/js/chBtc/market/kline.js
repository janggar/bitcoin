$(function () {
    Highcharts.setOptions({
        lang: {
            rangeSelectorZoom: ''
        }
    });
    $.getJSON('//data.jianshukeji.com/jsonp?filename=json/aapl-ohlcv.json&callback=?', function (data) {
        // split the data set into ohlc and volume
        var ohlc = [],
            volume = [],
            dataLength = data.length,
            // set the allowed units for data grouping
            groupingUnits = [[
                'week',                         // unit name
                [1]                             // allowed multiples
            ], [
                'month',
                [1, 2, 3, 4, 6]
            ]],
            i = 0;
        for (i; i < dataLength; i += 1) {
            ohlc.push([
                data[i][0], // the date
                data[i][1], // open
                data[i][2], // high
                data[i][3], // low
                data[i][4] // close
            ]);
            volume.push([
                data[i][0], // the date
                data[i][5] // the volume
            ]);
        }
        // create the chart
        $('#container').highcharts('StockChart', {
            rangeSelector: {
                selected: 1,
                inputDateFormat: '%Y-%m-%d'
            },
            title: {
                text: '苹果历史股价'
            },
            xAxis: {
                dateTimeLabelFormats: {
                    millisecond: '%H:%M:%S.%L',
                    second: '%H:%M:%S',
                    minute: '%H:%M',
                    hour: '%H:%M',
                    day: '%m-%d',
                    week: '%m-%d',
                    month: '%y-%m',
                    year: '%Y'
                }
            },
            yAxis: [{
                labels: {
                    align: 'right',
                    x: -3
                },
                title: {
                    text: '股价'
                },
                height: '60%',
                lineWidth: 2
            }, {
                labels: {
                    align: 'right',
                    x: -3
                },
                title: {
                    text: '成交量'
                },
                top: '65%',
                height: '35%',
                offset: 0,
                lineWidth: 2
            }],
            series: [{
                type: 'candlestick',
                name: 'AAPL',
                data: ohlc,
                dataGrouping: {
                    units: groupingUnits
                }
            }, {
                type: 'column',
                name: 'Volume',
                data: volume,
                yAxis: 1,
                dataGrouping: {
                    units: groupingUnits
                }
            }]
        });
    });
});

function getUserData(){
	$.ajax({
		url : "<%=path%>" + "/user/getUser.do",
		data : {
			userId : 1
		},
		dataType : 'JSON',
		type : 'POST',
		cache : false,
		success : function(data) {
			console.log(data);
			console.log(data[0].id);
			console.log(data.responseText);
		}
	});
}