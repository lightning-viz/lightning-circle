# Lightning Circle

Circle plot for **Lightning**

Documentation and examples at [lightning-viz.org](http://lightning-viz.org/documentation)

[![circle](https://raw.githubusercontent.com/lightning-viz/lightning-default-index/master/images/circle.png)](https://github.com/lightning-viz/lightning-circle)

## Usage options

### Lightning server

The Lightning server provides API-based access to reproducible, web-based visualizations. It can be deployed in many ways, including Heroku, Docker, a public server, a local app for OS X — and even a server-less version well-suited to notebooks like Jupyter. It comes bundled with a core set of visualizations, but is built to support custom ones.

[Read more about getting started with a Lightning server](http://lightning-viz.org/documentation/)

You can create an adjacency visualization using Python, Scala, JavaScript, or R by using API clients for making requests to a Lightning server.

#### Clients

Take a look at each client for installation and usage examples:

- [Python](https://github.com/lightning-viz/lightning-python)
- [Scala](https://github.com/lightning-viz/lightning-scala)
- [JavaScript](https://github.com/lightning-viz/lightning.js)
- [R](https://github.com/Ermlab/lightning-rstat)

#### Python circle example

```python
from lightning import Lightning
from numpy import random

lgn = Lightning()

connections = random.rand(50,50)
connections[connections<0.98] = 0

g1 = (random.rand(50) * 3).astype('int')
g2 = (random.rand(50) * 3).astype('int')
group = [g2, g1]

lgn.circle(connections, group=group)
```

#### Scala circle example

```scala
import org.viz.lightning._
import scala.util.Random

val lgn = Lightning()

val connections = Array.fill(50)(Array.fill(50)(Random.nextDouble()).map{ d =>
	if (d < 0.98) {
		d
	} else {
		0.0
	}
})

val g1 = Array.fill(50)(Random.nextInt() * 3)
val g2 = Array.fill(50)(Random.nextInt() * 3)
val group = g1 + g2

lgn.circle(connections, group=group)
```

## JavaScript module via npm

`lightning-circle` is an npm module that can be used on its own.

### Install as JavaScript module

```
npm i --save lightning-circle
```

### Example

```js
var Circle = require("lightning-circle")

var el = document.createElement("div");
document.body.appendChild(el);

var data = {
  nodes: [0, 1, 2, 3, 4, 5, 6, 7, 8],
  links: [[0, 1], [0, 2], [3, 5], [2, 4], [1, 2], [3, 4], [1, 5], [1, 6], [2, 7], [2, 8], [3, 8], [8, 7]],
  labels: ["a", "b", "c", "d", "e", "f", "g", "h", "i"],
  group: [[0, 0, 0, 1, 1, 1, 2, 2, 2]]
};

var options = {
  labels: true,
  width: 600,
  height: 400
};

var circle = new Circle(el, data, options);
```

### API

#### `var Circle = require("lightning-circle");`

#### `var circle = new Circle(selector, data, options);`

**Arguments:**  
- **selector** – css selector or dom node that will act as parent node of the visualization
- **data** – the required data for the Visualization
  - **nodes** – array representing nodes in the visualization
  - **group** – array representing groups
  - **links** – array of arrays describing the links between nodes
  - **labels** – array of strings
- **options**
  - **width** – *Number* – the width of the visualization
  - **height** – *Number* – the height of the visualization
  - **labels** – *Boolean* – `true` to show labels, `false to hide them` Default: `true`

## License
[MIT](LICENSE)
