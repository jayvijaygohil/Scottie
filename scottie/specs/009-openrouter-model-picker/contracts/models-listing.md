# Contract: Models Listing (consumed)

`GET {normalize(baseUrl)}/api/v1/models`, then each `links.next` resolved against the current
page URL until it is null or blank.

Headers: `Accept: application/json`; `Authorization: Bearer {apiKey}` only when the key is
non-blank.

## Fields read (all others ignored)

```json
{
  "data": [
    {
      "id": "anthropic/claude-haiku-5.5",
      "name": "Anthropic: Claude Haiku 5.5",
      "architecture": { "output_modalities": ["text"] }
    }
  ],
  "links": { "next": null }
}
```

| Field | Required | Handling |
|-------|----------|----------|
| `data` | no | missing → empty page |
| `data[].id` | no | blank or missing → entry skipped |
| `data[].name` | no | missing → shows `id` |
| `data[].architecture.output_modalities` | no | kept if it contains `text` or is missing |
| `links.next` | no | null, blank, or missing → last page; a repeated URL also stops |

## Responses

| Outcome | Result |
|---------|--------|
| 2xx, decodable | page merged; duplicates by `id` dropped |
| 401 / 403 | `Failed(AUTH)` |
| other status, or undecodable body | `Failed(OTHER)` |
| no response (DNS, connect, timeout, I/O) | `Failed(NO_CONNECTION)` |

Any failed page fails the whole fetch; partial lists are not shown.
